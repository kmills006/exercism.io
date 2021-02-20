export interface INameHistory {
  release(): void;
  save(name: string): void;
  isUnavailable(name: string): boolean;
}

export class NameHistory implements INameHistory {
  private _history: string[] = [];

  public release(): void {
    this._history = [];
  }

  public save(name: string): void {
    this._history.push(name);
  }

  public isUnavailable(name: string): boolean {
    return this._history.includes(name);
  }
}
