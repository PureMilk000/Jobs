#include<iostream>
#include<vector>
#include<algorithm>

using namespace std;

int main(){
    int length,k;
    vector<int> v;
    cin>>length;
    for(int i=0;i<length;++i){
        int tmp;
        cin>>tmp;
        v.push_back(tmp);
    }
    cin>>k;
    if(k>=length){
        cout<<"NULL"<<endl;
        return 0;
    }
    cout<<v[length-1-k]<<endl;
    return 0;
}