import { mapResistorColorsToValue } from './resistor-color-duo';

describe("Resistor Colors", () => {
  describe('functional', () => {
    it("Brown and black", () => {
      const actual = mapResistorColorsToValue(['brown', 'black']);
      expect(actual).toEqual(10)
    });

    it("Blue and grey", () => {
      const actual = mapResistorColorsToValue(["blue", "grey"])
      expect(actual).toEqual(68)
    });

    it("Yellow and violet", () => {
      const resistorColor = mapResistorColorsToValue(["yellow", "violet"])
      expect(resistorColor).toEqual(47)
    });

    it("Orange and orange", () => {
      const resistorColor = mapResistorColorsToValue(["orange", "orange"])
      expect(resistorColor).toEqual(33)
    });

    it("Ignore additional colors", () => {
      const actual = mapResistorColorsToValue(["green", "brown", "orange"])
      expect(actual).toEqual(51)
    });

    it("Throws error when not enough colors", () => {
      expect(() => mapResistorColorsToValue(["green"])).toThrowError(
        "At least two colors need to be present"
      );
    });
  });
});
