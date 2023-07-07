class Solution {
public:
    double findMedianSortedArrays(vector<int>& nums1, vector<int>& nums2) {
        int len1 = nums1.size(),len2 = nums2.size();
        int len = len1 + len2;
        int num[len];
        int k=0,j=0;
        int i;
        double mid;
        int m;
        for(i=0;i<len;i++)
        {
            if(k<len1 && j<len2)
            {
                if(nums1[k] < nums2[j])
                {
                    num[i] = nums1[k];
                    k++;
                }
                else
                {
                    num[i] = nums2[j];
                    j++;
                }
            }
            else if(k>=len1)
            {
                num[i] = nums2[j];
                j++;
            }
            else if(j>=len2)
            {
                num[i] = nums1[k];
                k++;
            }

        }
        mid = (len % 2 != 0) ? num[len/2] : (num[len/2] + num[len/2-1]) / 2.0;
        return mid;
    }
};
