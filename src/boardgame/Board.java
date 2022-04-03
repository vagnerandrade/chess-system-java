package boardgame;

public class Board {
	
	private int rows;
	private int columns;
	private Piece[][] pieces;
	
	public Board(int rows, int columns) {
		if (rows <1 || columns < 1) {
			throw new BoardException("Erro criando tabuleiro: � preciso quem tenha pelo menos uma linha e uma coluna ");
		}
		this.rows = rows;
		this.columns = columns;
		pieces = new Piece[rows][columns];
	}
	public int getRows() {
		return rows;
	}
	
	public int getColumns() {
		return columns;
	}
	

	public Piece piece(int row, int column) {
		if (!positionExists(row, column)) {
			throw new BoardException("posi��o n�o correta");
		}
		return pieces[row][column];
		}
	
	public Piece piece(Position position) {
		if (!positionExists(position)) {
			throw new BoardException("posi��o n�o correta");
		}
		return pieces[position.getRow()][position.getColumn()];
	}
	
	public void placePiece(Piece piece, Position position) {
		if (thereIsAPiece(position)) {
			throw new BoardException("J� existe uma pe�a na posi��o:" + position);
		}
		pieces[position.getRow()][position.getColumn()] = piece;
		piece.position = position;
	}
	
	public Boolean positionExists(int row, int column) {
		return row >= 0 && row < rows && column >= 0 && column < columns;
	}
	
	public Boolean positionExists(Position position) {
		return positionExists(position.getRow(), position.getColumn());
	}
	
	public boolean thereIsAPiece(Position position) {
		if (!positionExists(position)) {
			throw new BoardException("posi��o n�o correta");
		}
		return piece(position) != null;
	}
	
}
