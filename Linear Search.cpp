#include <iostream>
using namespace std;


int linear_search(int arr[], int n, int key){
    int start =0;
    int end=n-1;
    
    for(int i=1;i<=n;i++){
        if(arr[i]==key){
            return i;}
    }
    return -1;
}



int main(){
    int arr[] = {10,20,25,43,65,78,79,83,88,97};
    int n=sizeof(arr)/sizeof(int);
    
    int key;
    cin>>key;
    
    int index = linear_search(arr,n,key);
    
    if(index!=-1){
        cout<<key<<" is at location "<<index+1<<endl;}
    else{
        cout<<key<<" is NOT FOUND..."<<endl;
    }
    return 0;
}
