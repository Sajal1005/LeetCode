class Solution {
    public String sort(String s){
        char[] c = s.toCharArray();
        Arrays.sort(c);
        s= new String(c);
        return s;
    }
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> ans = new ArrayList<>();
        String[] str = new String[strs.length];
        for(int i=0;i<str.length;i++){
            str[i]=sort(strs[i]);
        }
        for(int i=0;i<str.length;i++){
            if(str[i].equals("#")) continue;
            ArrayList<String> temp = new ArrayList<>();
            temp.add(strs[i]);
            for(int j=i+1;j<str.length;j++){
                if(str[i].equals(str[j])){
                    temp.add(strs[j]);
                    str[j]="#";
                }
            }
            ans.add(temp);
        }
        return ans;
    }
}