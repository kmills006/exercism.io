type Planet = 'earth'
  | 'mercury'
  | 'venus'
  | 'mars'
  | 'jupiter'
  | 'saturn'
  | 'uranus'
  | 'neptune';

type PlanetOrbitalPeriod = Record<Planet, number>;

const SECONDS_IN_EARTH_YEARS = 31557600;

export const planetOrbitalPeriods: PlanetOrbitalPeriod = {
  earth: 1,
  mercury: 0.2408467,
  venus: 0.61519726,
  mars: 1.8808158,
  jupiter: 11.862615,
  saturn: 29.447498,
  uranus: 84.016846,
  neptune: 164.79132
};

interface ISpaceAge {
  ageOnPlanet: (planet: Planet) => number;
}

export class SpaceAge implements ISpaceAge {
  private readonly ageInSeconds: number;

  constructor(ageInSeconds: number) {
    this.ageInSeconds = ageInSeconds;
  }

  public get seconds(): number {
    return this.ageInSeconds;
  }

  public ageOnPlanet = (planet: Planet): number => this.ageOn(planet);

  private ageOn = (planet: Planet): number => (
    Number(((this.seconds / SECONDS_IN_EARTH_YEARS) / planetOrbitalPeriods[planet]).toFixed(2))
  )
}
