export const isPangram = (s: string): boolean => {
  const regex = /([a-z])(?!.*\1)/g;

  return (s.toLowerCase().match(regex) || []).length === 26;
};
