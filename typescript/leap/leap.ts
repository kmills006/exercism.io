const isYearDivisibleBy = (year: number) => (by: number) => (year % by) === 0;

export const isLeapYear = (year: number): boolean => {
  const isDivisibleBy = isYearDivisibleBy(year);

  return isDivisibleBy(4) && (!isDivisibleBy(100) || isDivisibleBy(400));
}
