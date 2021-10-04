import requests

def getType(typeList :list, data):

    try:
        typeList.append(data['types'][0]['type']['name'] + " / " + data['types'][1]['type']['name'])
    
    except:
        typeList.append(data['types'][0]['type']['name'])

    return typeList

def getTypes(x, limit):
    try:
        typeList = []
        while x <= limit: 
            url = requests.get("https://pokeapi.co/api/v2/pokemon/" + str(x))
            data = url.json()
            typeList = getType(typeList, data)
            x = x + 1
    except:
        print("types")        
    return typeList


def getNames(x, limit):
    try:
        namesList = []
        while x <= limit: 
            url = requests.get("https://pokeapi.co/api/v2/pokemon/" + str(x))
            data = url.json()
            namesList.append(data['name'])
            x = x + 1
    except:
        print("names")
    return namesList


def getWeight(x, limit):
    try:
        weightList = []
        while x <= limit: 
            url = requests.get("https://pokeapi.co/api/v2/pokemon/" + str(x))
            data = url.json()
            weightList.append(data['weight'])
            x = x + 1
    except:
        print("weight")        
    return weightList

def getHeight(x, limit):
    
    try:
        heightList = []
        while x <= limit: 
            url = requests.get("https://pokeapi.co/api/v2/pokemon/" + str(x))
            data = url.json()
            heightList.append(data['height'])
            x = x + 1
    except:
        print("height")
    return heightList

def getHealthPoints(x,limit):
    try:
        hp = []
        while x <= limit:
            url = requests.get("https://pokeapi.co/api/v2/pokemon/" + str(x))
            data = url.json()
            hp.append(data['stats'][0]['base_stat'])
            x = x + 1
    except:
        print("hp")
    return hp

def getAttack(x,limit):
    try: 
        attack = []
        while x <= limit:
            url = requests.get("https://pokeapi.co/api/v2/pokemon/" + str(x))
            data = url.json()
            attack.append(data['stats'][1]['base_stat'])
            x = x + 1
    except:
        print('attack')
    return attack

def getSpecialAttack(x,limit):

    try:
        specialAttack = []
        while x <= limit:
            url = requests.get("https://pokeapi.co/api/v2/pokemon/" + str(x))
            data = url.json()
            specialAttack.append(data['stats'][3]['base_stat'])
            x = x + 1
    except:
        print("special attack")
    return specialAttack

def getDefense(x,limit):

    try:
        defense = []
        while x <= limit:
            url = requests.get("https://pokeapi.co/api/v2/pokemon/" + str(x))
            data = url.json()
            defense.append(data['stats'][2]['base_stat'])
            x = x + 1
    except:
        print('defense')
    return defense

def getSpecialDefense(x,limit):

    try:
        specialDefense = []
        while x <= limit:
            url = requests.get("https://pokeapi.co/api/v2/pokemon/" + str(x))
            data = url.json()
            specialDefense.append(data['stats'][4]['base_stat'])
            x = x + 1
    except:
        print('Special Defense')
    return specialDefense

def getSpeed(x,limit):
    try:
        speed = []
        while x <= limit:
            url = requests.get("https://pokeapi.co/api/v2/pokemon/" + str(x))
            data = url.json()
            speed.append(data['stats'][5]['base_stat'])
            x = x + 1
    except:
        print("spped")
    return speed

def getFrontSprite(x,limit):
    
    try:
        frontSprite = []
        while x <= limit:
            url = requests.get("https://pokeapi.co/api/v2/pokemon/" + str(x))
            data = url.json()
            frontSprite.append(data['sprites']['front_default'])
            x = x + 1
    except: 
        print('FrontSprite')
    return frontSprite



def getBackSprite(x,limit):
    
    backSprite = []
    try:
        while x <= limit:
            url = requests.get("https://pokeapi.co/api/v2/pokemon/" + str(x))
            data = url.json()
            backSprite.append(data['sprites']['front_default'])
            x = x + 1
    except: 
        print('BaclSprite')
    return backSprite
