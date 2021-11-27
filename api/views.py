from django.http import response
from django.shortcuts import render
from django.http import JsonResponse, HttpResponse

import asyncio
from .utils import *


def sortByMonth(request):
    startPoint = request.GET['start']
    endPoint = request.GET['end']
    jsonData = getResponse(
        f"http://192.168.0.102:8080/transaction/allByMonth?start={startPoint}&end={endPoint}")
    df = pandas.json_normalize(jsonData)
    df['month'] = pandas.Categorical(df['month'], [
        "January",
        "February",
        "March",
        "April",
        "May",
        "June",
        "July",
        "August",
        "September",
        "October",
        "November",
        "December"
    ])
    barString = drawAndSaveBarChart('month', 'money', df)
    jsonData2 = getResponse(
        f"http://192.168.0.102:8080/transaction/allMoneyByCompanyName?start={startPoint}&end={endPoint}")
    df2 = pandas.json_normalize(jsonData2)
    pieString = drawAndSavePieChart('companyName', df2)
    df.to_csv("output.csv", index=False)
    csvString = toBinary("output.csv")
    return JsonResponse(jsonData, safe=False)


def sortByDay(request):
    startPoint = request.GET['start']
    endPoint = request.GET['end']
    jsonData = getResponse(
        f"http://192.168.0.102:8080/transaction/all?start={startPoint}&end={endPoint}")
    df = pandas.json_normalize(jsonData)
    df.sort_values(by=['dateTime'], inplace=True, ascending=True)
    barString = drawAndSaveBarChart('dateTime', 'money', df)
    jsonData2 = getResponse(
        f"http://192.168.0.102:8080/transaction/allMoneyByCompanyName?start={startPoint}&end={endPoint}")
    df2 = pandas.json_normalize(jsonData2)
    pieString = drawAndSavePieChart('companyName', df2)
    df.to_csv("output.csv", index=False)
    csvString = toBinary("output.csv")
    return JsonResponse(jsonData2, safe=False)
