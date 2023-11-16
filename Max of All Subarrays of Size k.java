 ArrayList<Integer> list=new ArrayList<>();
        
        if(n==1){
            list.add(arr[0]);
            return list;
        }
        
        
        for(int i=0;i<n-k+1;i++){
            list.add(findMax(arr,i,k));
        }
        
        return list;
    }
    
    static int findMax(int[] arr,int si,int k){
        int li=k+si;
        int max=arr[si];
        for(int i=si;i<li;i++){
           max= Math.max(max,arr[i]);
        }
        return max;
    }
