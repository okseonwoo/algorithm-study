#include <cstdio>
int array[64][64];
void func(int i, int j, int a, int b){
	bool zero = true;
	bool one = true;
	for(int k=i; k<j; k++){
		for(int q=a; q<b; q++){
			if(array[k][q]==0)
				one = false;
			if(array[k][q]==1)
				zero = false;
		}
	}
	if(one)
		printf("1");
	if(zero)
		printf("0");
	if(!one && !zero){
		printf("(");
		func(i, (i+j)/2, a, (a+b)/2);
		func(i, (i+j)/2, (a+b)/2, b);
		func((i+j)/2, j, a, (a+b)/2);
		func((i+j)/2, j, (a+b)/2, b);
		printf(")");
	}
}
int main(void){
	int N;
	scanf("%d", &N);
	for(int i=0; i<N; i++)
		for(int j=0; j<N; j++)
			scanf("%1d", &array[i][j]);
	func(0,N,0,N);
}