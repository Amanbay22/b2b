from pandas.io import json
import requests
import matplotlib.pyplot as plt
import seaborn as sns
import pandas
import base64


def getResponse(url):
    return requests.get(url).json()


def drawAndSavePieChart(uniqueValue, data):
    uniqueValues = pandas.unique(data[uniqueValue])
    piechartData = {}
    for value in uniqueValues:
        piechartData[value] = len(data.loc[data[uniqueValue] == value])
    plt.figure(figsize=(7, 7))
    colors = sns.color_palette('pastel')[0:len(uniqueValues)]
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
