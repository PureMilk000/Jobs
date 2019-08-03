//
//  main.cpp
//  exam
//
//  Created by mark on 2019/8/3.
//  Copyright © 2019年 mark. All rights reserved.
//

#include <iostream>
#include <vector>
#include <stack>
#include <queue>
#include <cmath>
#include <string>
#include <assert.h>
#include <cstdio>
#include <fstream>
#include <map>
#include <set>
#include <deque>
#include <algorithm>
#include <list>
using namespace std;

int a[10000];
void dfs(int cur,int n, vector<vector<int>> &res)//cur表示目前正在填的数，n表示总共要填的数
{
    vector<int> temp;
    if(cur==n)
    {
        for(int i=0 ; i<n; i++)
            temp.push_back(a[i]);
        
        res.push_back(temp);
    }
    for(int i=1;i<=n;i++)
    {
        int ok=1;
        for(int j=0;j<cur;j++)
        {
            if(a[j]==i) ok=0;
        }
        if(ok==1)
        {
            a[cur]=i;
            dfs(cur+1,n,res);
        }
    }
}



int main() {
    
    int n;
    cin >> n;
    
    vector<vector<int>> res;
    vector<int> input;
    int x;
    for(int i = 0; i < n; i++)
    {
        cin >> x;
        input.push_back(x);
    }
    
    dfs(0,n,res);
    int i, j, flag;
    for(i = 0; i < res.size(); i++)
    {
        if(res[i] == input)
            flag = i;
    }
    
    for(i = 0; i < n; i++)
        cout << res[res.size() - 1 - flag][i] << " ";
    cout << endl;
    
    return 0;
}
