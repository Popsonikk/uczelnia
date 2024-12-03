#include <cuda.h>
#include <iostream>


__global__ void initKernel(long * tab) {
    int index=threadIdx.x+blockIdx.x*blockDim.x;
    tab[index]=index;
    
    
}
__global__ void reduction(long * tab ,int step)
{
    int index=threadIdx.x+blockIdx.x*blockDim.x;
    if(index<step)
    tab[index]+=tab[index+step];
    
}

int main() {
    const int size=512;
    const int numblock=16;
    long * tab_gpu;
    cudaMalloc(&tab_gpu,sizeof(long)*size*numblock);
    initKernel <<<numblock,size>>> (tab_gpu);
    cudaDeviceSynchronize();
    for(int step=size*numblock;step>=1;step/=2)
    {
        reduction <<<numblock,size>>>(tab_gpu,step);
    }
    int result;
    cudaMemcpy(&result, tab_gpu,sizeof(long),cudaMemcpyDeviceToHost);
    std::cout<<result<<std::endl;

    return 0;
}