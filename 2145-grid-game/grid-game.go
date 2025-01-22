func gridGame(grid [][]int) int64 {
    top := int64(0)

    n := len(grid[0])
    for i:=0; i<n; i++ {
        top += int64(grid[0][i])
    }
    res := int64(math.MaxInt64)
    bottom := int64(0)
    for i:=0; i<n; i++ {
        top -= int64(grid[0][i])
        res = min(res, max(top, bottom))
        bottom += int64(grid[1][i])
    }

    return res
}

func min(a, b int64) int64 {
    if a < b {
        return a
    }
    return b
}

func max(a, b int64) int64 {
    if a > b {
        return a
    }
    return b
}