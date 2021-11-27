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
    responseData = requests.get("http://192.168.0.102:8080/transaction/all")
    jsonData = responseData.json()
    df = pandas.json_normalize(jsonData)
    plt.figure(figsize=(15, 7))
    sns.barplot(x='dateTime', y='money', data=df,
                color="mediumaquamarine", ci=None)
    plt.xticks(rotation=45)
    plt.savefig('barplot.png')
    print(pandas.unique(df['companyId']))
    with open("barplot.png", 'rb') as f:

        byteString = base64.b64encode(f.read())
    # return HttpResponse()
    return JsonResponse(jsonData, safe=False)
