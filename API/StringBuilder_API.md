## StringBuilder method
```java
//construtor
StringBuilder(): Constructs a string builder with no characters in it and an initial capacity of 16 characters.
StringBuilder(int capacity): Constructs a string builder with no characters in it and an initial capacity specified by the capacity argument.
StringBuilder(CharSequence seq): Constructs a string builder that contains the same characters as the specified CharSequence.
StringBuilder(String str): Constructs a string builder initialized to the contents of the specified string.

//API
StringBuilder insert(int offset, char c) 
    offset − This is the offset. 
    c − This is the char value.
StringBuilder.append(char a)
StringBuilder append(char[] astr)
StringBuilder append(char[] cstr, int iset, int ilength) 
    cstr – This refers to the Char sequence.
    iset – This refers to the index of the first char to append.
    ilenght – This refers to the number of chars to append.
StringBuilder append(CharSequence chseq, int start, int end) 
    chseq(CharSequence): This refers to the CharSequence value.
    start(Integer): This refers to the starting index of the subsequence to be appended..
    end(Integer): This refers to the end index of the subsequence to be appended.
StringBuilder delete(int start, int end)
    Removes the characters in a substring of this sequence.
    start - The beginning index, inclusive.
    end - The ending index, exclusive.
StringBuilder deleteCharAt(int index)
    Removes the char at the specified position in this sequence.
    index - Index of char to remove
StringBuilder insert(int offset, char[] str)
    Inserts the string representation of the char array argument into this sequence.
    offset - the offset.
    str - a character array.
StringBuilder replace(int start, int end,String str)
    start - The beginning index, inclusive.
    end - The ending index, exclusive.
    str - String that will replace previous contents.
```
