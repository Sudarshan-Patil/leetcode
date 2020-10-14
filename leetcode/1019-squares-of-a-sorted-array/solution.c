

/**
 * Note: The returned array must be malloced, assume caller calls free().
 */
int cmpfunc (const void * a, const void * b) {
   return ( *(int*)a - *(int*)b );
}

int* sortedSquares(int* A, int ASize, int* returnSize){    
    *returnSize = ASize;        
    for (int i=0; i<ASize; i++) {
        A[i] = pow(A[i],2);
    }
    qsort(A, ASize, sizeof(int), cmpfunc);
    return A;
}


