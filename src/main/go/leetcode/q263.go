package main

func isUgly(n int) bool {
	if n < 0 {
		return false
	}
	slice := []int{2, 3, 5}
	for _, item := range slice {
		for n%item == 0 {
			n /= item
		}
	}
	return n == 1
}

func main() {
	println(isUgly(5))
}
