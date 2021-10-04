import requests
from helperFunctions import *

global x , limit
x = 1
limit = 898

nameList = getNames(x, limit)
heightList = getHeight(x,limit)
weightList = getWeight(x, limit)
hpList = getHealthPoints(x,limit)
attackList = getAttack(x,limit)
defenseList = getDefense(x,limit)
SAList = getSpecialAttack(x,limit)
SDList = getDefense(x,limit)
speedList = getSpeed(x,limit)
fSpriteList = getFrontSprite(x,limit)
bSpriteList = getBackSprite(x,limit)
typeList = getTypes(x, limit)
sqlList = []

def generateSQLCodeTablePokemon(x, limit):
    
    

    while x <= limit:  
        line = ''
        line = 'INSERT INTO' + ' pokemon ' + '(pokemon_id,name,height,weight,health_points,attack,defense,special_attack,special_defense,speed,front_sprite,back_sprite,type) ' + 'VALUES '
        line = line + '(' + str(x) + ',' + '"' + nameList[x-1] + '",' + str(heightList[x-1]) + ',' + str(weightList[x-1]) + ',' + str(hpList[x-1]) 
        line = line +  ',' + str(attackList[x-1]) + ',' + str(defenseList[x-1]) + ',' + str(SAList[x-1]) + ',' + str(SDList[x-1]) 
        line = line +  ',' + str(speedList[x-1]) + ',' + '"' + fSpriteList[x-1] + '","' + bSpriteList[x-1]  + '","' + typeList[x-1] + '");'
        sqlList.append(line)
        x = x + 1
    return sqlList

sqlLista = generateSQLCodeTablePokemon(x,limit)

def generateScriptPokemonTable():
    f = open("pokemon-script-part1.sql", "w+")
    g = 0
    while g < len(sqlLista):
        f.write(sqlList[g] + "\n")
        g = g + 1
    f.close()    
    print("Script criado")

generateScriptPokemonTable()


