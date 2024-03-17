class Solution {
    public boolean reachingPoints(int sx, int sy, int tx, int ty) {
        if (sx > tx || sy > ty)
            return false;
        if (sx == tx && sy == ty)
            return true;
        return reachingPoints(sx, sx+sy, tx, ty) || reachingPoints(sx+sy, sy, tx, ty);
    }
}
