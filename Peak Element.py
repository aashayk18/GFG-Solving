l = 0
        r = n - 1
        while l <= r:
            mid = (l + r)//2
            if (((arr[mid] >= arr[mid-1]) or (mid == 0)) and ((mid == n-1) or (arr[mid] >= arr[mid+1]))):
                return mid
            elif arr[mid] < arr[mid + 1]:
                l = mid + 1
            else:
                r = mid - 1
        return 0
