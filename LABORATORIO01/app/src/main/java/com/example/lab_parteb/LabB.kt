package com.example.lab_parteb

class ItemData constructor(position: Int, data: Any, varType: String?, varInfo: String?){
    var originalPos: Int = position
    var originalValue: Any = data
    var type: String? = varType
    var info: String? = varInfo
}

fun main(){
    val myList: List<Any?>? = listOf(null, null, 5, "Hola")
    var finalList = processList(myList)

    if (finalList != null) {
        for (item in finalList){
            println("originalPos: ${item.originalPos}\n" +
                    "originalValue: ${item.originalValue}\n" +
                    "type: ${item.type}\n" +
                    "info: ${item.info}")
            println()
        }
    }
    else{
        println("El valor ingresado a la funcion fue $finalList")
    }
}
fun processList(itemList: List<Any?>?): List<ItemData>? {
    if(itemList != null){
        var newItemDataList: MutableList<ItemData> = mutableListOf<ItemData>()

        var itemPos: Int
        var value: Any
        var itemType: String?
        var itemInfo: String?

        for (item in itemList){
            itemPos = itemList.indexOf(item)

            if(item is Int){
                value = item!!
                itemType = "entero"

                if(item  % 10 == 0){
                    itemInfo = "M10"
                    var newItem = ItemData(itemPos, value, itemType, itemInfo)
                    newItemDataList.add(newItem)

                }
                else if(item  % 5 == 0){
                    itemInfo = "M5"
                    var newItem = ItemData(itemPos, value, itemType, itemInfo)
                    newItemDataList.add(newItem)
                }
                else if(item  % 2 == 0){
                    itemInfo = "M2"
                    var newItem = ItemData(itemPos, value, itemType, itemInfo)
                    newItemDataList.add(newItem)
                }
                else{
                    itemInfo = null
                    var newItem = ItemData(itemPos, value, itemType, itemInfo)
                    newItemDataList.add(newItem)
                }
            }
            else if(item is String){
                value = item!!
                itemType = "cadena"

                var strLength = (item as String).length
                itemInfo = "L$strLength"
                var newItem = ItemData(itemPos, value, itemType, itemInfo)
                newItemDataList.add(newItem)
            }
            else if(item is Boolean){
                value = item!!
                itemType = "booleano"

                if(item == true){
                    itemInfo = "Verdadero"
                    var newItem = ItemData(itemPos, value, itemType, itemInfo)
                    newItemDataList.add(newItem)
                }
                else if(item == false){
                    itemInfo = "Falso"
                    var newItem = ItemData(itemPos, value, itemType, itemInfo)
                    newItemDataList.add(newItem)
                }
            }
        }
        var list = newItemDataList.toList()

        return list
    }
    return null
}
