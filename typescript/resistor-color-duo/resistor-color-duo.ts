enum ResistanceValue {
  black = 0,
  brown = 1,
  red = 2,
  orange = 3,
  yellow = 4,
  green = 5,
  blue = 6,
  violet = 7,
  grey = 8,
  white = 9
}

type Color = keyof typeof ResistanceValue;

export const mapResistorColorsToValue = (colors: [Color, Color]): number => {
  if (colors.length < 2) {
    throw new Error('At least two colors need to be present');
  }

  const value = colors
    .slice(0, 2)
    .map((color: Color) => ResistanceValue[color])
    .join('');

  return parseInt(value, 10);
};
