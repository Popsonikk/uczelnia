#include <cuda.h>
#include <iostream>


__global__ void addKernel(int * a ,int * b,int * res  )
{
    int index=threadIdx.x;
    res[index]=a[index]+b[index];
    
}

int main() {
    const int size=512;
    int *a=(int*)malloc(size*sizeof(int));
    int *b=(int*)malloc(size*sizeof(int));
    int *res=(int*)malloc(size*sizeof(int));
    for(int i=0;i<size;i++)
    {
        a[i]=i;
        b[i]=i;
    }
    int* a_gpu;
    int* b_gpu;
    int* res_gpu;
    cudaMalloc(&a_gpu,sizeof(int)*size);
    cudaMalloc(&b_gpu,sizeof(int)*size);
    cudaMalloc(&res_gpu,sizeof(int)*size);
    cudaMemcpy(a_gpu, a,sizeof(int)*size,cudaMemcpyHostToDevice);
    cudaMemcpy(b_gpu, b,sizeof(int)*size,cudaMemcpyHostToDevice);

    addKernel <<<1,size>>> (a_gpu,b_gpu,res_gpu);
    cudaDeviceSynchronize();
    
    cudaMemcpy(res, res_gpu,sizeof(int),cudaMemcpyDeviceToHost);
    for(int i=0;i<size;i++)
        std::cout<<res[i]<<"|";

    return 0;
}