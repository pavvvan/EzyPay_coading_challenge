# EzyPay_coading_challenge

This repo is for Ezypay hiring process :


#Solution

Both app will be running on the diffrent process to communicate with the process we have to use IPC in android it can be handled by AIDL

By Using Android AIDL- Handling the inter process communication(IPC) in android


Created 2 apps "AppOneEzPay" and "AppTwoEzPay" 

In "AppOneEzPay":

Created an android module "app1modulemathops" and impemented function called "getMathOpsResult(int num1, int num2, boolean isAdd, IMathOpsApp2 addService)" which will trigger the "AppTwoEzPay" AppOneEzypay is binded to service in AppTwoEzPay

In "AppTwoEzPay":

Created a service component and exposed to service with api defined in AIDL 

![](domo.gif)
