import requests

global X
x = 1

global numOfPoke
numOfPoke = 898

def getMovesbyId(pokemon_id):
    from helperFunctions import getAllMoves
    
    moveList = []
    url = requests.get("https://pokeapi.co/api/v2/pokemon/" + str(pokemon_id))
    data = url.json()
    moveList = getAllMoves(moveList,data)
    
    return moveList

#moveList = getMovesbyId(4)
#print(len(moveList))






def makingSQlScriptPokeMoveTable():
        
        pokemon = 1
        sqlList = []
        while pokemon <= numOfPoke:
            moveList = getMovesbyId(pokemon)
            line = ""
            y = 0
            while y < 100:
                try:

                    line = "INSERT INTO move (pokemon_id,move) VALUES("+ str(pokemon) +",'" +  moveList[y] + "');"
                    y = y + 1
                    sqlList.append(line)            
                except:
                    break
                    
            pokemon = pokemon + 1
                
        return sqlList


#print(makingSQlScriptPokeMoveTable(x))

def generateScriptPokeMoveTable():
    sqlList = makingSQlScriptPokeMoveTable()
    f = open("poke-move-script.sql", "w+")
    g = 0
    while g < len(sqlList):
        f.write(sqlList[g] + "\n")
        g = g + 1
    f.close()    
    print("Script criado")

generateScriptPokeMoveTable()

            