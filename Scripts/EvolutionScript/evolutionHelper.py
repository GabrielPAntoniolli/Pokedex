import requests
       
def eeveeHelperFuncRight():
    counter1 = 0
    counter2 = 0
    last = 7
    eeveeArray = []
    dictionary = {}

    url = requests.get("https://pokeapi.co/api/v2/evolution-chain/" + str(67))
    data = url.json()
    
    eevee = (data["chain"]["species"]["url"])
    eevee = eevee[42:-1]
    
    while counter1 <= last:
        currEvo = (data["chain"]["evolves_to"][counter1]["species"]["url"])
        currEvo = currEvo[42:-1]
        eeveeArray.append(currEvo)
        counter1 = counter1 + 1

    eeveeDict = {eevee : eeveeArray}
    dictionary.update(eeveeDict)
    eeveeArray2 = [eevee]
    while counter2 <= last:

        currEvo = (data["chain"]["evolves_to"][counter2]["species"]["url"])
        currEvo = currEvo[42:-1]
        dictionary.update({ currEvo : eeveeArray2})
        counter2 = counter2 + 1
    
    return dictionary

def hitmonHelperFuncRight():
    counter1 = 0
    counter2 = 0
    last = 2
    hitmonArray = []
    dictionary = {}

    url = requests.get("https://pokeapi.co/api/v2/evolution-chain/" + str(47))
    data = url.json()
    
    hitmon = (data["chain"]["species"]["url"])
    hitmon = hitmon[42:-1]
    
    while counter1 <= last:
        currEvo = (data["chain"]["evolves_to"][counter1]["species"]["url"])
        currEvo = currEvo[42:-1]
        hitmonArray.append(currEvo)
        counter1 = counter1 + 1

    dictionary.update({hitmon : hitmonArray})
    hitmonArray2 = [hitmon]
    while counter2 <= last:

        currEvo = (data["chain"]["evolves_to"][counter2]["species"]["url"])
        currEvo = currEvo[42:-1]
        dictionary.update({ currEvo : hitmonArray2})
        counter2 = counter2 + 1
    
    return dictionary

def gloomHelperFuncRight():
    counter1 = 0
    counter2 = 0
    last = 1
    gloomArray = []
    dictionary = {}
    #dictionary.update({'43':'44'})

    url = requests.get("https://pokeapi.co/api/v2/evolution-chain/" + str(18))
    data = url.json()
    
    gloom = (data["chain"]["evolves_to"][0]["species"]["url"])
    gloom = gloom[42:-1]
    
    while counter1 <= last:
        currEvo = (data["chain"]["evolves_to"][0]["evolves_to"][counter1]["species"]["url"])
        currEvo = currEvo[42:-1]
        gloomArray.append(currEvo)
        counter1 = counter1 + 1

    dictionary.update({gloom : gloomArray})
    gloomArray2 = [gloom]
    
    while counter2 <= last:

        currEvo = (data["chain"]["evolves_to"][0]["evolves_to"][counter2]["species"]["url"])
        currEvo = currEvo[42:-1]
        dictionary.update({ currEvo : gloomArray2})
        counter2 = counter2 + 1
    
    return dictionary   
     
   