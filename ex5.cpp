#include<bits/stdc++.h>
using namespace std;
int main(){
    int n1,n2,n3;
    cin>>n1>>n2>>n3;
    queue<int> s1,s2,s3;
    int sum1=0,sum2=0,sum3=0;
    for(int i=0;i<n1;i++){
        int x;
        cin>>x;
        sum1+=x;
        s1.push(x);
    }
    for(int i=0;i<n2;i++){
        int x;
        cin>>x;
        sum2+=x;
        s2.push(x);
    }
    for(int i=0;i<n3;i++){
        int x;
        cin>>x;
        sum3+=x;
        s3.push(x);
    }
    while(1){
        if(sum1==sum2 && sum2==sum3){
            cout<<sum1;
            break;
        }
        int mi=min(sum1,min(sum2,sum3));
        cout<<sum1<<" "<<sum2<<" "<<sum3<<" "<<mi<<endl;
        if(sum1>mi){
            sum1-=s1.front();
            s1.pop();
        }
        if(sum2>mi){
            sum2-=s2.front();
            s2.pop();
        }
        if(sum3>mi){
            sum3-=s3.front();
            s3.pop();
        }
    }
    return 0;
}