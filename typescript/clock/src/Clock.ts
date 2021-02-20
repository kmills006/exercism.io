class Clock {
  private _hours: number;
  private _minutes: number;

  constructor(hours: number, minutes: number = 0) {
    this._hours = (24 + ((hours + Math.floor(minutes / 60)) % 24)) % 24;
    this._minutes = (60 + (minutes % 60)) % 60;
  }

  public toString(): string {
    return `${this.padZero(this._hours)}:${this.padZero(this._minutes)}`;
  }

  public plus(minutes: number): Clock {
    return new Clock(this._hours, (this._minutes + minutes));
  }

  public minus(minutes: number): Clock {
    return new Clock(this._hours, (this._minutes - minutes));
  }

  public equals(clock: Clock): boolean {
    return (clock._minutes === this._minutes) && (clock._hours === this._hours);
  }

  private padZero(num: number): string {
    return num.toString().padStart(2, '0');
  }
}

export default Clock;
