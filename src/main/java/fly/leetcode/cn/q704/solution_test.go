package main

import (
	. "github.com/smartystreets/goconvey/convey"
	"testing"
)

func TestSearch(t *testing.T) {
	Convey("二分查找", t, func() {
		So(search([]int{-1, 0, 3, 5, 9, 12}, 9), ShouldEqual, 4)
		So(search([]int{-1, 0, 3, 5, 9, 12}, 2), ShouldEqual, -1)
	})
}
