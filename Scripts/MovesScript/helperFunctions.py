def getAllMoves(moveList :list, data):
    i = 0
    while i < 4:
        try:
            moveList.append(data["moves"][i]["move"]["name"])
            i = i + 1
        except:
            i = i + 1

    return moveList