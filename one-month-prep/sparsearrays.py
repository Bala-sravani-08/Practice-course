def matchingStrings(stringList, queries):
  returnList = []
  for values in queries:
      returnList.append(stringList.count(values))
  return returnList
