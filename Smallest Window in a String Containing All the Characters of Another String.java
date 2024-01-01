public static String smallestWindow(String s, String p) {
        String result = "-1";
        int count = 0;
        Map<Character, Integer> map = new HashMap<>();
        
        for (int i = 0; i < p.length(); i++) {
            char ch = p.charAt(i);
            if (!map.containsKey(ch)) {
                ++count;
                map.put(ch, 1);
            } else {
                map.put(ch, map.get(ch) + 1);
            }
        }
        
        int i = 0;
        int j = 0;
        int length = Integer.MAX_VALUE;
        while (j < s.length()) {
            char ch = s.charAt(j);
            
            if (map.containsKey(ch)) {
                map.put(ch, map.get(ch) - 1);
                
                if (map.get(ch) == 0) {
                    count--;
                }
            }
            
            while (count == 0) {
                ch = s.charAt(i);
                
                if (map.containsKey(ch)) {
                    if (map.get(ch) == 0) {
                        String potentialResult = s.substring(i, j + 1);
                        if (potentialResult.length() < length) {
                            result = potentialResult;
                            length = potentialResult.length();
                        }
                        ++count;
                    }
                    map.put(ch, map.get(ch) + 1);
                }
                ++i;
            }
            
            ++j;
        }
        
        return result;
    }
