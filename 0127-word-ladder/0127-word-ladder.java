class Solution {
  public int ladderLength(String beginWord, String endWord, List<String> wordList) {

    if(!wordList.contains(endWord)) return 0;

    Set<String> beginSet=new HashSet<>();
    Set<String> endSet=new HashSet<>();
    Set<String> wordSet=new HashSet<>(wordList);
    beginSet.add(beginWord);
    endSet.add(endWord);
    return bfs(beginSet,endSet,wordSet,1);
  }

  int bfs(Set<String> beginSet,Set<String> endSet,Set<String> wordSet,int distance){


    if(beginSet.size()>endSet.size()){
      return bfs(endSet,beginSet,wordSet,distance);
    }

    Set<String> reachableWords=new HashSet<>();
    wordSet.removeAll(beginSet);
    for(String word:beginSet){
      for(int pos=0;pos<word.length();pos++){ 
        char[] charArray=word.toCharArray();
        for(char c='a';c<='z';c++){
          charArray[pos]=c;

          String newWord=new String(charArray);
          if(wordSet.contains(newWord)){
            if(endSet.contains(newWord)){
              return distance + 1;
            }
            reachableWords.add(newWord);
            //wordSet.remove(newWord);
          }
        }
      }
    }
    distance++;
    if(reachableWords.size()==0){
      return 0;
    }
    else{
      return bfs(reachableWords,endSet,wordSet,distance);
    }
  }
}