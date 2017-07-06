package codility.D20170610;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import java.util.List;
import java.util.stream.Collectors;

public class Task3_Woohyun {

    private boolean[][] visited;
    private int[][] board;
    private Position destPosition;
    private Map<Position, Integer> cache = new HashMap<>();

    enum Movement {
        ONE(-2, 1),
        TWO(-1, 2),
        THREE(1, 2),
        FOUR(2, 1),
        FIVE(2, -1),
        SIX(1, -2),
        SEVEN(-1, -2),
        EIGHT(-2, -1);

        Movement(int x, int y) {
            this.x = x;
            this.y = y;
        }

        Position getNextMove(Position current) {
            return new Position(current.x + this.x, current.y + this.y);
        }

        int x;
        int y;
    }

    static class Position {

        public Position(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public int x;
        public int y;

        public boolean isValidPosition() {
            return this.x >= 0 && this.y >= 0;
        }

        public boolean isInTheBoard(Position limitPos) {
            return this.x <= limitPos.x && this.y <= limitPos.y;
        }

        @Override
        public String toString() {
            return "Position{" + "x=" + x + ", y=" + y + '}';
        }

        //Map 사용하려고 equals, hasCode 생성
        @Override
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (!(o instanceof Position)) {
                return false;
            }

            Position position = (Position) o;

            if (x != position.x) {
                return false;
            }
            return y == position.y;
        }

        @Override
        public int hashCode() {
            int result = x;
            result = 31 * result + y;
            return result;
        }
    }

    private final int DEAD_END = Integer.MAX_VALUE;

    public int solution(int[][] A) {
        this.board = A;
        this.visited = new boolean[A.length][A[0].length];
        this.destPosition = new Position(A.length - 1, A[0].length - 1);

        Position currentPos = new Position(0, 0);
        int result = findShortestTravel(currentPos);
        return result == DEAD_END? -1 : result;
    }

    private int findShortestTravel(Position currentPosition) {
        if (currentPosition.equals(destPosition)) return 0;
        if (cache.containsKey(currentPosition)) return cache.get(currentPosition); //메모이제이션 사용

        markVisited(currentPosition);

        List<Position> availMovements = getValidMovementFromCurrentPos(currentPosition);

        int minMovements = DEAD_END;
        for (Position nextPosition : availMovements) { //현재 위치에서 최소값을 찾기 위해 재귀로 호출
            minMovements = Math.min(minMovements, findShortestTravel(nextPosition));
        }
        unmarkVisited(currentPosition);

        int result = (minMovements == DEAD_END)? DEAD_END : minMovements + 1;
        cache.put(currentPosition, result);
        return result;
    }

    private List<Position> getValidMovementFromCurrentPos(final Position current) {
        return Arrays.stream(Movement.values())
                .map(movement -> movement.getNextMove(current))
                .filter(Position::isValidPosition)
                .filter(position -> position.isInTheBoard(destPosition))
                .filter(this::canMoveTo)
                .collect(Collectors.toList());
    }

    private boolean canMoveTo(Position position) {
        if (this.visited[position.x][position.y]) return false;

        return (board[position.x][position.y] == 0);
    }

    private void markVisited(Position position) {
        this.visited[position.x][position.y] = true;
    }

    private void unmarkVisited(Position position) {
        this.visited[position.x][position.y] = false;
    }
}