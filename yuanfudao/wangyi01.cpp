#include <iostream>
#include <vector>
#include <algorithm>
#include <string>

using namespace std;

class Solution{
public:
    static void maxCommonDivisor(int a,int b)
    {
        int t,c;
        if (a<b)
        {
            t=a;
            a=b;
            b=t;
        }
        c=a-b;
        if (a%c==0&&b%c==0){
            cout<<c<<endl;
        }
        else
        {
            a=b;
            b=c;
            maxCommonDivisor(a,b);
        }
    }
};
int main(){
    int a,b;
    cin>>a;
    cin>>b;
    Solution::maxCommonDivisor(a,b);
    system("pause");
    return 0;
}