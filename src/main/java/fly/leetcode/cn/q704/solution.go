package main

func main() {
}

func search(nums []int, target int) int {
	return search_pos(nums, target, 0, len(nums)-1)
}

func search_pos(nums []int, target int, start int, end int) int {
	for start < end {
		mid := (start + end) / 2
		if nums[mid] == target {
			return mid
		} else if nums[mid] < target {
			return search_pos(nums, target, mid+1, end)
		} else {
			return search_pos(nums, target, start, mid-1)
		}
	}
	return -1

}
