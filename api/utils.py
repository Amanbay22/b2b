from pandas.io import json
import requests
import matplotlib.pyplot as plt
import seaborn as sns
import pandas
import base64
from django.http import HttpResponse, JsonResponse


def writeToDatabase(collection, data):
    collection.insert_many([data])


def getDatabase():
    from pymongo import MongoClient
    import pymongo
    CONNECTION_STRING = "mongodb+srv://stage:stage@mongodb.jrd7u.mongodb.net/myFirstDatabase?retryWrites=true&w=majority"
    from pymongo import MongoClient
    client = MongoClient(CONNECTION_STRING)
    return client['BTOB']


def toBinary(fileUrl):
    with open(fileUrl, 'rb') as f:
        binaryString = base64.b64encode(f.read())
    return binaryString


def getResponse(url):
    return requests.get(url).json()


def getAllTransactions(request):
    startPoint = request.GET['start']
    endPoint = request.GET['end']
    data = getResponse(
        f"http://192.168.43.52:8080/transaction?start={startPoint}&end={endPoint}")
    df = pandas.json_normalize(data)
    plt.figure(figsize=(15, 7))
    sns.histplot(data=df, x="dateTime",
                 hue=df['status.name'], multiple="stack")
    plt.xticks(rotation=45)
    plt.savefig('histplot.png')
    with open("histplot.png", 'rb') as f:
        histString = base64.b64encode(f.read())
    return histString


def drawAndSavePieChart(uniqueValue, data):
    uniqueValues = pandas.unique(data[uniqueValue])
    piechartData = {}
    for value in uniqueValues:
        piechartData[value] = len(data.loc[data[uniqueValue] == value])
    plt.figure(figsize=(7, 7))
    colors = sns.color_palette('pastel')[0: len(uniqueValues)]
    plt.pie(piechartData.values(), labels=uniqueValues,
            colors=colors, autopct='%.0f%%')
    plt.savefig('pieplot.png')
    with open("pieplot.png", 'rb') as f:
        pieString = base64.b64encode(f.read())
    return pieString


def drawAndSaveBarChart(xAxis, yAxis, data):
    plt.figure(figsize=(15, 7))
    sns.barplot(x=xAxis, y=yAxis, data=data,
                color="mediumaquamarine", ci=None)
    plt.xticks(rotation=45)
    plt.savefig('barplot.png')
    with open("barplot.png", 'rb') as f:
        barString = base64.b64encode(f.read())
    return barString