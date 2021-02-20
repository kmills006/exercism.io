type MatrixArray = number[][];

class Matrix {
  public rows: MatrixArray = [];
  public columns: MatrixArray = [];

  constructor(str: string) {
    this.rows = str
      .split('\n')
      .map((x) => (
        x.split(' ').map((s) => parseInt(s))
      ));

    this.columns = this.rows.map((_, columnIndex) => (
      this.rows.map((row) => row[columnIndex])
    ));
  }
}

export default Matrix
