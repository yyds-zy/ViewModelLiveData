# ViewModelLiveData

## ViewModel
ViewModel 类旨在以注重生命周期的方式存储和管理界面相关数据。ViewModel 类让数据可在发生屏幕旋转等配置更改后继续留存。
Android 框架可以管理界面控制器（如 activity 和 fragment）的生命周期。Android 框架可能会决定销毁或重新创建界面控制器，以响应完全不受您控制的某些用户操作或设备事件。

如果系统销毁或重新创建界面控制器，则存储在其中的任何瞬态界面相关数据都会丢失。例如，应用的某个 Activity 中可能包含用户列表。因配置更改而重新创建 activity 后，新 activity 必须重新提取用户列表。对于简单的数据，activity 可以使用 onSaveInstanceState() 方法从 onCreate() 中的捆绑包恢复其数据，但此方法仅适合可以序列化再反序列化的少量数据，而不适合数量可能较大的数据，如用户列表或位图。
Android 框架可以管理界面控制器（如 activity 和 fragment）的生命周期。Android 框架可能会决定销毁或重新创建界面控制器，以响应完全不受您控制的某些用户操作或设备事件。

如果系统销毁或重新创建界面控制器，则存储在其中的任何瞬态界面相关数据都会丢失。例如，应用的某个 Activity 中可能包含用户列表。因配置更改而重新创建 activity 后，新 activity 必须重新提取用户列表。对于简单的数据，activity 可以使用 onSaveInstanceState() 方法从 onCreate() 中的捆绑包恢复其数据，但此方法仅适合可以序列化再反序列化的少量数据，而不适合数量可能较大的数据，如用户列表或位图。
