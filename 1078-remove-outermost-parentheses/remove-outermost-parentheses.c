

char * removeOuterParentheses(char * S){
    char * removedParenthesis = (char *)malloc(sizeof(char) * strlen(S));
    int count = -1, i = 0, j = 0, previousCount;
    
    while(S[i] != 0)
    {
        if(S[i] == '(') 
            ++count;
        else 
            --count;        
        
        if (count > 0 || (count !=-1 && S[i] == ')')) {
            removedParenthesis[j++] = S[i];
        }        

        ++i;
    }
    removedParenthesis[j] = 0;
    
    return removedParenthesis;
}