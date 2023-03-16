package me.jeongseok.cote.recursion;


/**
 * #include <stdio.h>
 * #include <string.h>
 *
 * int recursion(const char *s, int l, int r){
 *     if(l >= r) return 1;
 *     else if(s[l] != s[r]) return 0;
 *     else return recursion(s, l+1, r-1);
 * }
 *
 * int isPalindrome(const char *s){
 *     return recursion(s, 0, strlen(s)-1);
 * }
 *
 * int main(){
 *     printf("ABBA: %d\n", isPalindrome("ABBA")); // 1
 *     printf("ABC: %d\n", isPalindrome("ABC"));   // 0
 * }
 */
public class BOJ_25501 {

	public static void main(String[] args) {

	}

}
