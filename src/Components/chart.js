import React from "react";
import { Chart } from "react-google-charts";
export const data = [
  ["Expenses", "In Dollars"],
  ["Employees", 78930],
  ["Office Supplies",1000],
  ["Production Supplies", 45000],
  ["Transport", 34120],
  ["Tax", 17937],
];

export const options = {
  legend: "none",
  pieSliceText: "label",
  title: "Fiscal Quarter Expenses",
  pieStartAngle: 100,
};

export function Chart1() {
  return (
    <Chart
      chartType="PieChart"
      data={data}
      options={options}
      width={"300px"}
      height={"400px"}
    />
  );
}
export default Chart1;