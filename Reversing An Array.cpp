#include <iostream>
using namespace std;


int reverse_Arr(int arr[], int n){
    int start =0;
    int end=n-1;
    
    while(start<end){
        swap(arr[start],arr[end]);
        start+=1;
        end-=1;
    }return 0;
}



int main(){
    int arr[] = {10,20,25,43,65,78,79,83,88,97};
    int n=sizeof(arr)/sizeof(int);
    
    for(int i=0;i<n;i++){
        cout<<arr[i]<<" ";}
    cout<<endl;
    
    
    reverse_Arr(arr,n);
    
    for(int i=0;i<n;i++){
        cout<<arr[i]<<" ";}
    cout<<endl;
    
    return 0;
}
