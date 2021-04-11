package main

import "fmt"

var (
	i2   int
	i3   int
	i5   int
	next = 1
	ugly = [1690]int{1, 0}
)

func nthUglyNumber(n int) int {
	for ugly[n-1] == 0 {
		var n2, n3, n5 = ugly[i2] * 2, ugly[i3] * 3, ugly[i5] * 5
		min := min(n2, n3, n5)
		if min == n2 {
			i2++
		}
		if min == n3 {
			i3++
		}
		if min == n5 {
			i5++
		}
		ugly[next] = min
		next++
	}
	return ugly[n-1]
}

func min(x int, y int, z int) int {
	var t int
	if x < y {
		t = x
	} else {
		t = y
	}
	if z < t {
		t = z
	}
	return t
}

func main() {
	n := nthUglyNumber(10)
	fmt.Println(n)
}
