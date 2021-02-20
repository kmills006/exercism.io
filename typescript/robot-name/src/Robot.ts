import { RobotName } from './RobotName';
import { NameHistory } from './NameHistory';

export default class Robot {
  private static _history: NameHistory = new NameHistory();

  private _name: string;
  private _robotName: RobotName = new RobotName(Robot._history);

  constructor() {
    this._name = this._robotName.name();
  }

  public get name(): string {
    return this._name;
  }

  public resetName(): void {
    this._name = this._robotName.name();
  }

  public static releaseNames(): void {
    Robot._history.release();
  }
}
