import { NameHistory } from './NameHistory';

export class RobotName {
  private _history: NameHistory;

  private _letters = 'ABCDEFGHIJKLMNOPQRSTUVWXYZ'.split('')
  private _digits = '0123456789'.split('')
  private _nameSpec = [
    this._letters,
    this._letters,
    this._digits,
    this._digits,
    this._digits,
  ];

  constructor(history: NameHistory) {
    this._history = history;
  }

  public name(): string {
    return this.generate().next().value;
  }

  private *generate(): Generator<string> {
    const name = this.buildName();

    if (this._history.isUnavailable(name)) {
      yield * this.generate()
    }

    this._history.save(name)

    yield name;
  }

  private buildName(): string {
    return this._nameSpec
      .map((s) => s[Math.floor(Math.random() * s.length)])
      .join('');
  }
}

