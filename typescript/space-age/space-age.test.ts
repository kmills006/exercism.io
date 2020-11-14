import { SpaceAge } from './space-age'

describe('Space Age', () => {
  it('age in seconds', () => {
    const spaceAge = new SpaceAge(1000000);
    expect(spaceAge.seconds).toEqual(1000000)
  });

  it('age in earth years', () => {
    const spaceAge = new SpaceAge(1000000000);
    expect(spaceAge.ageOnPlanet('earth')).toEqual(31.69)
  });

  it('age in mercury years', () => {
    const spaceAge = new SpaceAge(2134835688)
    expect(spaceAge.ageOnPlanet('earth')).toEqual(67.65)
    expect(spaceAge.ageOnPlanet('mercury')).toEqual(280.88)
  });

  it('age in venus years', () => {
    const spaceAge = new SpaceAge(189839836)
    expect(spaceAge.ageOnPlanet('earth')).toEqual(6.02)
    expect(spaceAge.ageOnPlanet('venus')).toEqual(9.78)
  });

  it('age in mars years', () => {
    const age = new SpaceAge(2329871239)
    expect(age.ageOnPlanet('earth')).toEqual(73.83)
    expect(age.ageOnPlanet('mars')).toEqual(39.25)
  });

  it('age in jupiter years', () => {
    const age = new SpaceAge(901876382)
    expect(age.ageOnPlanet('earth')).toEqual(28.58)
    expect(age.ageOnPlanet('jupiter')).toEqual(2.41)
  });

  it('age in saturn years', () => {
    const age = new SpaceAge(3000000000)
    expect(age.ageOnPlanet('earth')).toEqual(95.06)
    expect(age.ageOnPlanet('saturn')).toEqual(3.23)
  });

  it('age in uranus years', () => {
    const age = new SpaceAge(3210123456)
    expect(age.ageOnPlanet('earth')).toEqual(101.72)
    expect(age.ageOnPlanet('uranus')).toEqual(1.21)
  });

  xit('age in neptune year', () => {
    const age = new SpaceAge(8210123456)
    expect(age.ageOnPlanet('earth')).toEqual(260.16)
    expect(age.ageOnPlanet('neptune')).toEqual(1.58)
  });
})
