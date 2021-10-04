import requests

global x, limit
x = 1
limit = 475


def getEvolutionChainRight(x,limit):

    from evolutionHelper import eeveeHelperFuncRight,hitmonHelperFuncRight,gloomHelperFuncRight    
    evolutionDict = {}
    while x <= limit:
        if x == 47: # hitmonlee
            evolutionDict.update(hitmonHelperFuncRight())
            x = x + 1

        if x == 67: # eevee
            evolutionDict.update(eeveeHelperFuncRight())
            x = x + 1
        
        if x == 18:
            evolutionDict.update(gloomHelperFuncRight())
            x = x + 1
        else:
            try:
                url = requests.get("https://pokeapi.co/api/v2/evolution-chain/" + str(x))
                data = url.json()
                first = (data["chain"]["species"]["url"])
                first = first[42:-1]
                print(x)
            
             
                try:
                    second = (data["chain"]["evolves_to"][0]["species"]["url"])
                    second = second[42:-1]
                    firstArray = [second]
                    evolutionDict.update({first : firstArray})
                    secondArray = []
                    secondArray.append(first)
                    x = x + 1
                    
                    try:
                        third = (data["chain"]["evolves_to"][0]["evolves_to"][0]["species"]["url"])
                        third = third[42:-1]
                        secondArray.append(third)
                        evolutionDict.update({second : secondArray})
                        thirdArray = [second]
                        evolutionDict.update({third : thirdArray})

                    except:
                        evolutionDict.update({second : secondArray})

                except:
                    x = x + 1

            except: x = x + 1

    return evolutionDict

def makingQueryScriptRight():
    evolutionMap = getEvolutionChainRight(x,limit)
    queryList = []
    numPoke = 1
    #while numPoke <= 151: #o que deu certo
    while numPoke <= 898: #number of Pokemons
        try:
            list = evolutionMap[str(numPoke)]
        
            i = 0    
            while i <= len(list) - 1:
                
                line = "INSERT INTO evolution (pokemon_id,evolve_to) "
                line = line +"VALUES (" +str(numPoke) + "," +str(list[i]) + ");"
                queryList.append(line)
                i = i + 1
            numPoke = numPoke + 1
        except: 
            numPoke = numPoke + 1

    return queryList

def generateScript():
    sqlList = makingQueryScriptRight()
    f = open("evolutions-part-1.sql", "w+")
    g = 0
    while g < len(sqlList):
        f.write(sqlList[g] + "\n")
        g = g + 1
    f.close()    
    print("Script criado")

generateScript()

#map = getEvolutionChainRight(x,limit)
#print(map)


