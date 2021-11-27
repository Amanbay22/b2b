from django.http import response
from django.shortcuts import render
from django.http import JsonResponse, HttpResponse
import requests
import matplotlib.pyplot as plt
import seaborn as sns
import pandas
import base64
# Create your views here.

# TODO:
# Dataframe
#


def index(request):
    responseData = requests.get(
        "http://192.168.0.110:9999/transaction/all?start=2021-03-27&end=2021-11-24")
    jsonData = responseData.json()
    df = pandas.json_normalize(jsonData)
    df.sort_values(by=['dateTime'], inplace=True, ascending=True)
    plt.figure(figsize=(15, 7))
    sns.barplot(x='dateTime', y='money', data=df,
                color="mediumaquamarine", ci=None)
    plt.xticks(rotation=45)
    plt.savefig('barplot.png')
    companies = pandas.unique(df['company_name'])
    piechartData = {}
    for company in companies:
        piechartData[company] = len(df.loc[df['company_name'] == company])
    plt.figure(figsize=(7, 7))
    with open("barplot.png", 'rb') as f:
        barString = base64.b64encode(f.read())
    colors = sns.color_palette('pastel')[0:len(companies)]
    plt.pie(piechartData.values(), labels=companies,
            colors=colors, autopct='%.0f%%')
    plt.savefig('pieplot.png')
    with open("pieplot.png", 'rb') as f:
        pieString = base64.b64encode(f.read())
    return JsonResponse(jsonData, safe=False)
